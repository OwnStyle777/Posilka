import React, { useEffect, useState } from 'react';
import { FlatList, TouchableOpacity, StyleSheet, SafeAreaView, View, StatusBar } from 'react-native';
import { Searchbar, Card, Title, Paragraph } from 'react-native-paper';
import { getAllExercises } from '@/app/api/ExerciseService';
import { Exercise } from '@/types/Exercise';
import { Image } from 'react-native';
import { SvgUri } from 'react-native-svg';
import ExerciseDetail from '@/app/ExerciseDetail';
import { Link, router } from 'expo-router';
import { linkTo } from 'expo-router/build/global-state/routing';

const ExerciseList = ({ navigation }: any) => {
  const [search, setSearch] = useState('');
  const [allExercises, setAllExercises] = useState<Exercise[]>([]);
  const [filteredExercises, setFilteredExercises] = useState<Exercise[]>([]);

  useEffect(() => {
    const fetchExercises = async () => {
      try {
        const response = await getAllExercises();
        const exercisesFromApi: Exercise[] = response.data;
        setAllExercises(exercisesFromApi);
        setFilteredExercises(exercisesFromApi);
      } catch (error) {
        console.error('Error fetching exercises:', error);
      }
    };

    fetchExercises();
  }, []);

  const handleSearch = (query: string) => {
    setSearch(query);
    const filteredData = allExercises.filter(exercise =>
      exercise.name.toLowerCase().includes(query.toLowerCase())
    );
    setFilteredExercises(filteredData);
  };

  
  const renderItem = ({ item }: { item: Exercise }) => {
    const exerciseId = item.id;

    return (
      <TouchableOpacity
        onPress={() => {
          console.log("exerciseId: " + exerciseId)
          if (exerciseId) {
            router.push({
              pathname: '/ExerciseDetail',
              params: { exerciseId: String(item.id) },
            });
          } else {
            console.warn('exerciseId is missing');
          }
        }}
    
      >
        <Card style={styles.card}>
          <Card.Content style={styles.cardContent}>
            {item.mediaUrl?.endsWith('.svg') ? (
              <SvgUri width="40" height="40" uri={item.mediaUrl} />
            ) : (
              <SvgUri width="40" height="40" uri="https://www.svgrepo.com/download/382003/exercise-health-fitness-weight.svg" />
            )}
            <View style={styles.textContainer}>
              <Title>{item.name}</Title>
              <Paragraph>{item.muscleGroup}</Paragraph>
            </View>
          </Card.Content>
        </Card>
      </TouchableOpacity>
    );
  };

  return (
    <SafeAreaView style={styles.safeArea}>
      <StatusBar barStyle="dark-content" backgroundColor="#fff" />
      <Searchbar
        placeholder="Search exercises"
        onChangeText={handleSearch}
        value={search}
        style={styles.searchbar}
      />
      <FlatList
        data={filteredExercises}
        renderItem={renderItem}
        keyExtractor={(item) => item.id?.toString() || ''}
        contentContainerStyle={styles.listContent}
      />
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  safeArea: {
    flex: 1,
    backgroundColor: '#fff',
    paddingHorizontal: 10,
    paddingTop: 10,
  },
  searchbar: {
     backgroundColor: '#D1F5FF',
    marginBottom: 10,
  },
  listContent: {
    paddingBottom: 20,
  },
  card: {
    marginBottom: 10,
    backgroundColor: '#f9f9f9',
    borderRadius: 8,
    elevation: 2,
  },
  cardContent: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 10,
  },
  textContainer: {
    marginLeft: 10,
  },
  icon: {
    width: 40,
    height: 40,
    borderRadius: 5,
    marginRight: 10,
  },
});

export default ExerciseList;